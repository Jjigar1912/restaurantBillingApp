package com.example.resturant_billing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.example.resturant_billing.model.*;

import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAddFragment extends Fragment{ //  implements View.OnClickListener

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //    List food item
    private List<order_item> foodList= new ArrayList<order_item>();

    private String mParam1;
    private String mParam2;

    public ItemAddFragment() {
        // Required empty public constructor
    }

    public static ItemAddFragment newInstance(String param1, String param2) {
        ItemAddFragment fragment = new ItemAddFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_add, container, false);

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


        GridLayout foodItemContainer=(GridLayout) view.findViewById(R.id.foodItemGrid);

        for (order_item item : foodList){
            // Create the main LinearLayout
            LinearLayout mainLayout = new LinearLayout(getContext());
            mainLayout.setBackground(getResources().getDrawable(R.drawable.itemcardbkg));
            mainLayout.setOrientation(LinearLayout.VERTICAL);
            mainLayout.setId(item.getId());
            mainLayout.setClickable(true);
            mainLayout.setPadding(
                    dpToPx(5),
                    dpToPx(5),
                    dpToPx(5),
                    dpToPx(5)
            );
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    dpToPx(150),
                    dpToPx(130)
            );

            layoutParams.setMargins(dpToPx(10),dpToPx(10),dpToPx(10),dpToPx(10));

            mainLayout.setLayoutParams(layoutParams);
            mainLayout.setGravity(View.TEXT_ALIGNMENT_CENTER);
            mainLayout.setOrientation(LinearLayout.VERTICAL);

            // Create the TextView for the Food Item Name
            TextView foodItemTextView = new TextView(getContext());
            foodItemTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    dpToPx(80)
            ));
            foodItemTextView.setGravity(Gravity.CENTER_VERTICAL);
            foodItemTextView.setPadding(dpToPx(5), 0, 0, 0);
            foodItemTextView.setTextSize(17);
            foodItemTextView.setTextColor(getResources().getColor(R.color.white));
            foodItemTextView.setText(item.getName());

            // Create the horizontal line
            View horizontalLine = new View(getContext());
            horizontalLine.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    dpToPx(1)
            ));
            horizontalLine.setBackgroundColor(getResources().getColor(R.color.white));
            ((LinearLayout.LayoutParams) horizontalLine.getLayoutParams()).gravity = Gravity.CENTER_VERTICAL;

            // Create the nested LinearLayout for the EditText and TextViews
            LinearLayout nestedLayout = new LinearLayout(getContext());
            nestedLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    dpToPx(40)
            ));
            nestedLayout.setPadding(0,dpToPx(1),0,dpToPx(1));
            nestedLayout.setGravity(Gravity.CENTER);
            nestedLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Create the EditText
            EditText editText = new EditText(getContext());
            editText.setLayoutParams(new LinearLayout.LayoutParams(
                    dpToPx(40),
                    dpToPx(30)
            ));
            editText.setPadding(0,0,0,0);
            editText.setGravity(Gravity.CENTER);
            editText.setBackground(getResources().getDrawable(R.drawable.edittexttransparentbkg));
            editText.setTextColor(getResources().getColor(R.color.white));
            editText.setTextSize(15);
            editText.setText(Integer.toString(item.getQty()));

            // Create the first TextView
            TextView firstTextView = new TextView(getContext());
            firstTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    dpToPx(30),
                    dpToPx(30)
            ));
            firstTextView.setGravity(Gravity.CENTER);
            firstTextView.setTextColor(getResources().getColor(R.color.white));
            firstTextView.setTextSize(20);
            firstTextView.setText("--");


            //decrease the quantity of item---------------------------------------
            //--------------------------------------------------------------------
            firstTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(item.getQty() > 0){
                        item.setQty(item.getQty()-1);
                        editText.setText(Integer.toString(item.getQty()));
                        Toast.makeText(getContext(), Integer.toString(item.getQty()), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //---------------------------------------------------------

            // Create the second TextView
            TextView secondTextView = new TextView(getContext());
            secondTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    dpToPx(50),
                    dpToPx(40)
            ));
            secondTextView.setGravity(Gravity.CENTER | Gravity.END);
            secondTextView.setTextColor(getResources().getColor(R.color.white));
            secondTextView.setTextSize(15);
            secondTextView.setText(Integer.toString(item.getPrice()));

            // Add views to the nested layout
            nestedLayout.addView(editText);
            nestedLayout.addView(firstTextView);
            nestedLayout.addView(secondTextView);

            // Add views to the main layout
            mainLayout.addView(foodItemTextView);
            mainLayout.addView(horizontalLine);
            mainLayout.addView(nestedLayout);

            //increase the quantity of item ----------------------------------------------------
            //----------------------------------------------------------------------------------
            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.setQty(item.getQty()+1);
                    editText.setText(Integer.toString(item.getQty()));
                    Toast.makeText(getContext(), Integer.toString(item.getQty()), Toast.LENGTH_SHORT).show();
                }
            });


            foodItemContainer.addView(mainLayout);
        }




        return view;
    }


    private int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float widthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
        return (int) widthInPx;
    }
}