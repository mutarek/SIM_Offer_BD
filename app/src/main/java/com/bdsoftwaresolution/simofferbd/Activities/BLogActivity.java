package com.bdsoftwaresolution.simofferbd.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.bdsoftwaresolution.simofferbd.Adapters.BD_Travel_Adapter;
import com.bdsoftwaresolution.simofferbd.Interfaces.Each_Blog_Click;
import com.bdsoftwaresolution.simofferbd.Models.BD_travel_model;
import com.bdsoftwaresolution.simofferbd.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class BLogActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<BD_travel_model> bd_travel_models;
    private BD_Travel_Adapter bd_travel_adapter;
    private Context context;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("BD_Travel");
    private DocumentReference d = collectionReference.document();
    private ProgressDialog progressDialog;
    private SearchView searchView;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        recyclerView = findViewById(R.id.blog_reculler);
        searchView = findViewById(R.id.blog_search);
        bd_travel_models = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait.......");
        initRecyller();
        initSearchView();
    }

    private void initSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                db.collection("BD_Travel")
                        .whereEqualTo("spot", query)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Error getting documents 1: " + task.getResult().size());
                                    //QuerySnapshot document = task.getResult();
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                    }
                                } else {
                                    Log.d(TAG, "Error getting documents 2: ", task.getException());

                                }

                            }
                        });
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    private void initRecyller() {
        progressDialog.show();
        collectionReference.limit(10).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        final BD_travel_model bd_travel_model = document.toObject(BD_travel_model.class);
                        bd_travel_models.add(bd_travel_model);

                        bd_travel_adapter = new BD_Travel_Adapter(new Each_Blog_Click() {
                            @Override
                            public void OnBlogClick(View blogView, int blogPosition) {
                                Intent intent = new Intent(BLogActivity.this, FullArticleActivity.class);
                                intent.putExtra("data", bd_travel_models.get(blogPosition).getDesc());
                                intent.putExtra("img", bd_travel_models.get(blogPosition).getImg());
                                intent.putExtra("title", bd_travel_models.get(blogPosition).getTitle());
                                startActivity(intent);
                            }
                        }, bd_travel_models, context);
                        recyclerView.setAdapter(bd_travel_adapter);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(BLogActivity.this);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.addItemDecoration(new DividerItemDecoration(BLogActivity.this, DividerItemDecoration.VERTICAL));

                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(BLogActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
