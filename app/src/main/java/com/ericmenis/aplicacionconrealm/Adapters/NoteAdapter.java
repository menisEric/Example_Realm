package com.ericmenis.aplicacionconrealm.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ericmenis.aplicacionconrealm.Models.Note;
import com.ericmenis.aplicacionconrealm.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class NoteAdapter extends BaseAdapter {

    private Context context;
    private List<Note> list;
    private int layout;

    public NoteAdapter(Context context, List<Note> list, int layout){
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder vh;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new Viewholder();
            vh.description = (TextView) convertView.findViewById(R.id.textViewNoteDescription);
            vh.createdAt = (TextView) convertView.findViewById(R.id.textViewNoteCraetedAt);
            convertView.setTag(vh);
        }else {
            vh = (Viewholder) convertView.getTag();
        }

        Note note = list.get(position);

        vh.description.setText(note.getDescription());

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(note.getCraetedAt());
        vh.createdAt.setText(date);

        return convertView;
    }

    public class Viewholder{
        TextView description;
        TextView createdAt;
    }
}
