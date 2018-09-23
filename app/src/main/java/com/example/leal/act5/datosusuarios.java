package com.example.leal.act5;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class datosusuarios
        extends RecyclerView.Adapter<datosusuarios.ViewHolderUsuarios>
        implements View.OnClickListener{

    ArrayList<usuarios> listaUsuarios;
    private View.OnClickListener listener;

    public datosusuarios(ArrayList<usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public ViewHolderUsuarios onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (utilidades.visualizacion==utilidades.LIST){
            layout=R.layout.datos;
        }else {
            layout=R.layout.datoss;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderUsuarios(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderUsuarios holder, int position) {
        holder.Nombre.setText(listaUsuarios.get(position).getNombre());

        if (utilidades.visualizacion==utilidades.LIST){
            holder.Apellido.setText(listaUsuarios.get(position).getApellido());
            holder.Edad.setText(listaUsuarios.get(position).getEdad());
        }

        holder.foto.setImageResource(listaUsuarios.get(position).getFoto());
    }


    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderUsuarios extends RecyclerView.ViewHolder {

        TextView Nombre,Apellido, Edad;
        ImageView foto;

        public ViewHolderUsuarios(View itemView) {
            super(itemView);
            Nombre= (TextView) itemView.findViewById(R.id.nomusuario);
            if (utilidades.visualizacion==utilidades.LIST){
                Apellido= (TextView) itemView.findViewById(R.id.apeusuario);
                Edad = (TextView) itemView.findViewById(R.id.edadusuario);
            }
            foto= (ImageView) itemView.findViewById(R.id.fotousuario);
        }
    }
}