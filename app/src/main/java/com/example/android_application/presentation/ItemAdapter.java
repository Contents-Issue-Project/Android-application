package com.example.android_application.presentation;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.Data.DataFormat;
import com.example.android_application.R;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> implements Contract.View{

    private Context context;
    private List<ItemData> list = new ArrayList<>();

    public ItemAdapter(Context context, List<ItemData> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    // 몇 개의 데이터를 리스트로 뿌려줘야 하는지 반드시 정의해줘야 한다.
    @Override
    public int getItemCount() {
        return list.size();  // RecyclerView의 size return
    }

    public void addItems(ArrayList<ItemData> items) {
        list.addAll(items);
    }


    public void addItem(ItemData item) {
        list.add(item);
    }

    @Override
    public void setUpContent(DataFormat dataformat) {
        for (DataFormat.Item item : dataformat.data) {
            addItem(new ItemData(item.title_kr, item.date, item.type, item.top_word));
        }
        notifyDataSetChanged();
    }

    @Override
    public void handleWrongRequest(WrongRequestException exception) {
    System.out.println("Wrong Request");
    }

    @Override
    public void handleDataUnavailable(DataUnavailableException exception) {
        System.out.println("Data unavailable");
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다.
    public class Holder extends RecyclerView.ViewHolder {
        public TextView titleText;
        public TextView dateText;
        public TextView typeText;
        public TextView genreText;
        public TextView top_wordText;

        public Holder(View view) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.item_title);
            dateText = (TextView) view.findViewById(R.id.item_date);
            typeText = (TextView) view.findViewById(R.id.item_type);
            //genreText = (TextView) view.findViewById(R.id.item_genre);
            top_wordText = (TextView) view.findViewById(R.id.top_word);

        }
    }

    // Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.titleText.setText(list.get(itemposition).title);
        holder.dateText.setText(list.get(itemposition).release_date);
        holder.typeText.setText(list.get(itemposition).type);
        //holder.genreText.setText(list.get(itemposition).genre);
        holder.top_wordText.setText(list.get(itemposition).top_word);
        Log.e("StudyApp", "onBindViewHolder" + itemposition);
    }
}