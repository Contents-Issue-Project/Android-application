package com.example.android_application.presentation.trending.Fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android_application.R;
import com.example.android_application.presentation.trending.Fragment.Home.ItemData;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.Holder> {

    private Context context;
    private List<ItemData> list = new ArrayList<>();

    public ViewAdapter(Context context, List<ItemData> list) {
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

    // Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.titleText.setText(list.get(itemposition).title);
        holder.dateText.setText(list.get(itemposition).release_date);
        holder.typeText.setText(list.get(itemposition).type);
        holder.genreText.setText(list.get(itemposition).genre);
        holder.statisticsText.setText(list.get(itemposition).statistics);
        Log.e("StudyApp", "onBindViewHolder" + itemposition);
    }

    // 몇 개의 데이터를 리스트로 뿌려줘야 하는지 반드시 정의해줘야 한다.
    @Override
    public int getItemCount() {
        return list.size();  // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다.
    public class Holder extends RecyclerView.ViewHolder {
        public TextView titleText;
        public TextView dateText;
        public TextView typeText;
        public TextView genreText;
        public TextView statisticsText;

        public Holder(View view) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.item_title);
            dateText = (TextView) view.findViewById(R.id.item_date);
            typeText = (TextView) view.findViewById(R.id.item_type);
            genreText = (TextView) view.findViewById(R.id.item_genre);
            statisticsText = (TextView) view.findViewById(R.id.item_statistics);
        }
    }
}