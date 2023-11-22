package com.example.resturant_billing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;


import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.resturant_billing.model.order_item;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.TypeReference;

public class ItemsOnTable extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    PdfDocument document;
    private String mParam1;
    private String mParam2;

    private List<order_item> foodList= new ArrayList<order_item>();

    public ItemsOnTable() {
        // Required empty public constructor
    }

    public static ItemsOnTable newInstance(String param1, String param2) {
        ItemsOnTable fragment = new ItemsOnTable();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_items_on_table, container, false);

        TableLayout tableLayout = view.findViewById(R.id.foodListTable);


        if(getArguments() == null){
            foodList.add(new order_item(11,"Pizza Margherita",180,"pizza",1,180));
            foodList.add(new order_item(12,"Pizza Vegetarian",175,"pizza",2,175*2));
            foodList.add(new order_item(13,"Veggie Burger",120,"burger",1,120));
            foodList.add(new order_item(14,"Cheeseburger",140,"burger",3,420));
            foodList.add(new order_item(15,"Greek Salad",220,"salad",2,440));
            foodList.add(new order_item(16,"Grilled Cheese",60,"sandwich",4,240));
            foodList.add(new order_item(17,"Grilled Salmon",180,"seafood",1,180));
            foodList.add(new order_item(18,"Spicy Chicken Curry",180,"special",1,180));
            foodList.add(new order_item(19,"Paneer Tikka Masala",220,"special",1,220));
            foodList.add(new order_item(20,"Cola",30,"Beverages",2,60));
            foodList.add(new order_item(21,"Mango Lassi",60,"Beverages",1,60));
        }else{
            Gson gson = new Gson();
            Type listType = new TypeToken<List<order_item>>() {}.getType();
            foodList=gson.fromJson(getArguments().getString("order"), listType);

        }



        // Inflate the layout for this fragment
        // Create a new table row
        int i=1;
        int sum=0;
        TableLayout bill=(TableLayout) view.findViewById(R.id.billTable);
       for(order_item item : foodList){
           sum+=item.getQty()*item.getPrice();
           TableRow row = new TableRow(getContext());
           row.setLayoutParams(new TableLayout.LayoutParams(
                   TableLayout.LayoutParams.MATCH_PARENT,
                   TableLayout.LayoutParams.WRAP_CONTENT));
           row.setPadding(5, 0, 5, 0);
           TextView index = new TextView(getContext());
           index.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT));
           index.setText(Integer.toString(i));
           index.setGravity(Gravity.CENTER);
           index.setLayoutParams(new TableRow.LayoutParams(
                   0,
                   TableRow.LayoutParams.WRAP_CONTENT,
                   0.5f));

           ///Item name --------------------------

           TextView itemname = new TextView(getContext());
           itemname.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT));
           itemname.setText(item.getName());
           itemname.setGravity(Gravity.CENTER);
           itemname.setLayoutParams(new TableRow.LayoutParams(
                   0,
                   TableRow.LayoutParams.WRAP_CONTENT,
                   2f));

           /////  item Quantity ----------------------

           TextView itemQty = new TextView(getContext());
           itemQty.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT));
           itemQty.setText(Integer.toString(item.getQty()));
           itemQty.setGravity(Gravity.CENTER);
           itemQty.setLayoutParams(new TableRow.LayoutParams(
                   0,
                   TableRow.LayoutParams.WRAP_CONTENT,
                   0.5f));


           // item Total --------------------------------

           TextView itemTotal = new TextView(getContext());
           itemTotal.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT));
           itemTotal.setText(Integer.toString(item.getQty() * item.getPrice()));
           itemTotal.setGravity(Gravity.CENTER);
           itemTotal.setLayoutParams(new TableRow.LayoutParams(
                   0,
                   TableRow.LayoutParams.WRAP_CONTENT,
                   1f));
           row.addView(index);
           row.addView(itemname);
           row.addView(itemQty);
           row.addView(itemTotal);
           bill.addView(row);



            TableRow tableRow = new TableRow(getContext());
           if(i%2==0){
               tableRow.setBackgroundColor(getResources().getColor(R.color.white));
           }else{
               tableRow.setBackgroundColor(getResources().getColor(R.color.tableRowColor));

           }
           tableRow.setPadding(5, 5, 5, 5);

           // Create the first TextView
           TextView index1 = new TextView(getContext());
           index1.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
           index1.setText(Integer.toString(i));

           // Create the second TextView
           TextView itemName = new TextView(getContext());
           itemName.setLayoutParams(new TableRow.LayoutParams(
                   200, // Set the width in pixels or use appropriate measure
                   TableRow.LayoutParams.WRAP_CONTENT, 2f));
           itemName.setText(item.getName());

           // Create the third TextView
           TextView qty = new TextView(getContext());
           qty.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
           qty.setText(Integer.toString(item.getQty()));

           //create the fourth TextView
           TextView price = new TextView(getContext());
           price.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
           price.setText(Integer.toString(item.getPrice()));

           // Create the fifth TextView
           TextView totalOfitem = new TextView(getContext());
           totalOfitem.setLayoutParams(new TableRow.LayoutParams(
                   TableRow.LayoutParams.WRAP_CONTENT,
                   TableRow.LayoutParams.WRAP_CONTENT, 1f));
           totalOfitem.setText(Integer.toString(item.getQty() * item.getPrice()));

           // Add TextViews to the TableRow
           tableRow.addView(index1);
           tableRow.addView(itemName);
           tableRow.addView(qty);
           tableRow.addView(price);
           tableRow.addView(totalOfitem);

           // Add TableRow to your TableLayout (assuming you have a TableLayout in your XML layout)

           tableLayout.addView(tableRow);

           i++;
       }

        TextView total1=(TextView) view.findViewById(R.id.totalPrice);
        total1.setText(Integer.toString(sum));
//
       TextView total=(TextView) view.findViewById(R.id.totalCost);
       total.setText(Integer.toString(sum));




        LinearLayout billstructure=(LinearLayout) view.findViewById(R.id.billStructure);

        AppCompatButton printBtn=(AppCompatButton) view.findViewById(R.id.printBill);

        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePDFfromView(billstructure);
            }
        });


        return view;
    }


    public void generatePDFfromView(View view){
        Bitmap bitmap=getBitmapFromView(view);
        document=new PdfDocument();

        PdfDocument.PageInfo myPageInfo=new PdfDocument.PageInfo.Builder(bitmap.getWidth(),bitmap.getHeight(),1).create();
        PdfDocument.Page myPage= document.startPage(myPageInfo);
        Canvas canvas=myPage.getCanvas();
        canvas.drawBitmap(bitmap,0,0,null);
        document.finishPage(myPage);
        createFile();

    }

    public Bitmap getBitmapFromView(View view){
        Bitmap returnedBitmap=Bitmap.createBitmap(view.getWidth(),view.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas=new Canvas(returnedBitmap);

        Drawable bgDrawable=view.getBackground();

        if(bgDrawable != null){
            bgDrawable.draw(canvas);
        }else{
            canvas.drawColor(getResources().getColor(R.color.white));
        }

        view.draw(canvas);

        return returnedBitmap;
    }

    public void createFile(){
        Intent intent=new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_TITLE,"invoice.pdf");
        startActivityForResult(intent, 1);
    }



    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float widthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
        return (int) widthInPx;
    }





}