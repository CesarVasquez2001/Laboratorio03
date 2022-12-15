package com.example.lab03.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab03.Postulante;
import com.example.lab03.R;

import java.util.List;

public class PostulanteAdapter extends RecyclerView.Adapter<PostulanteAdapter.ViewHolder> {


    List<Postulante> postulanteList;

    public PostulanteAdapter(List<Postulante> postulanteList) {
        this.postulanteList = postulanteList;
    }


    @NonNull
    @Override
    public PostulanteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostulanteAdapter.ViewHolder holder, int position) {
        Postulante postulante= postulanteList.get(position);
        holder.dniTxt.setText(postulante.getDNI());
        holder.fullnameTxt.setText("Nombre completo: "+postulante.getNombres()+" "+postulante.getApellidos());
        holder.fechaTxt.setText("Fecha de Nac.: "+postulante.getFechaNac());
        holder.colegioTxt.setText("Colegio: "+ postulante.getColegio() );
        holder.carreraTxt.setText("Carrera: "+postulante.getCarrera() );

        boolean isExpandable= postulanteList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return postulanteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dniTxt,fullnameTxt,fechaTxt,colegioTxt,carreraTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            dniTxt = itemView.findViewById(R.id.code_name);
            fullnameTxt= itemView.findViewById(R.id.fullname);
            fechaTxt= itemView.findViewById(R.id.fecha);
            colegioTxt= itemView.findViewById(R.id.colegio);
            carreraTxt   = itemView.findViewById(R.id.carrera);


            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout= itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Postulante postulante= postulanteList.get(getAdapterPosition());
                    postulante.setExpandable(!postulante.isExpandable());
                    notifyItemChanged(getAdapterPosition());

                }
            });

        }
    }
}
