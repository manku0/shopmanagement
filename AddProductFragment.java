package com.maya.shopdetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.maya.shopdetails.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

public class AddProductFragment extends Fragment {
EditText producttype,productcompanyname,productmodel,productprice;

    Button Addcement;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);

        Addcement = view.findViewById(R.id.btnaddcement);
        producttype = view.findViewById(R.id.producttype);
        productcompanyname = view.findViewById(R.id.produc_tcompany_Name);
        productmodel = view.findViewById(R.id.product_model_name);
        productprice = view.findViewById(R.id.product_model_price);

   Addcement.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String ptype = producttype.getText().toString();
        String pcomname= productcompanyname.getText().toString();
        String pmodel = productmodel.getText().toString();
        String pprice = productprice.getText().toString();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        Map<String, Object> product = new HashMap<>();
        product.put("Product Type :-", ptype);
        product.put("Product Company", pcomname);
        product.put("Product Model", pmodel);
        product.put("Product Model price", pprice);

        if (pcomname.isEmpty() || pmodel.isEmpty() || ptype.isEmpty()||pprice.isEmpty()){
            Toast.makeText(getContext(), "fill All Field's", Toast.LENGTH_SHORT).show();
            return;
        }

        database.getReference(ptype).child(pcomname).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(getContext(), "Successfully Added Product", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Product not Added", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
});


return view;
    }
}