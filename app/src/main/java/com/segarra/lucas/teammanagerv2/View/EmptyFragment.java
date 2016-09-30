package com.segarra.lucas.teammanagerv2.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.movildat.lucassegarra.teammangaerv2.R;


/**
 * Created by lucas.segarra on 30/09/2016.
 */
public class EmptyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_empty,viewGroup,false);
    }
}
