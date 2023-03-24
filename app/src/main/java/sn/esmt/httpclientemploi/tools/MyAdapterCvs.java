package sn.esmt.httpclientemploi.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sn.esmt.httpclientemploi.R;
import sn.esmt.httpclientemploi.httpconfig.CvsResponses;

public class MyAdapterCvs extends BaseAdapter {


    private ArrayList<CvsResponses> cvs;
    private LayoutInflater myInflater;

    public MyAdapterCvs(Context context, ArrayList<CvsResponses> cvs)
    {
        this.myInflater = LayoutInflater.from(context);
        this.cvs = cvs;
    }

    @Override
    public int getCount() {
        return this.cvs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.cvs.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textId;
        TextView textNom;
        TextView textPrenom;

        TextView textAge;
        TextView textAdresse;
        TextView textEmail;
        TextView textTelephone;

        TextView textSpecialite;
        TextView textNiveauEtude;
        TextView textExperienceProfessionnelle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = myInflater.inflate(R.layout.listitem_cvs, null);
            holder = new ViewHolder();
            holder.textId = (TextView) convertView.findViewById(R.id.txtId);
            holder.textNom = (TextView) convertView.findViewById(R.id.txtNom);
            holder.textPrenom = (TextView) convertView.findViewById(R.id.txtPrenom);
            holder.textAge = (TextView) convertView.findViewById(R.id.txtAge);
            holder.textAdresse = (TextView) convertView.findViewById(R.id.txtAdresse);
            holder.textEmail = (TextView) convertView.findViewById(R.id.txtMail);
            holder.textTelephone = (TextView) convertView.findViewById(R.id.txtTelephone);

            holder.textSpecialite = (TextView) convertView.findViewById(R.id.txtSpecialite);
            holder.textNiveauEtude = (TextView) convertView.findViewById(R.id.txtNiveauEtude);
            holder.textExperienceProfessionnelle = (TextView) convertView.findViewById(R.id.txtExperienceProfessionnelle);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textId.setText(cvs.get(position).getId()+"");
        holder.textNom.setText(cvs.get(position).getNom());
        holder.textPrenom.setText(cvs.get(position).getPrenom());
        holder.textAge.setText(cvs.get(position).getAge());
        holder.textAdresse.setText(cvs.get(position).getAdresse());
        holder.textEmail.setText(cvs.get(position).getEmail());
        holder.textTelephone.setText(cvs.get(position).getTelephone());

        holder.textSpecialite.setText(cvs.get(position).getSpecialite());
        holder.textNiveauEtude.setText(cvs.get(position).getNiveauEtude());
        holder.textExperienceProfessionnelle.setText(cvs.get(position).getExperienceProfessionnelle());

        return convertView;

    }

}
