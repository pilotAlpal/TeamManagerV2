package com.segarra.lucas.teammanagerv2.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Controller.Controller;
import com.segarra.lucas.teammanagerv2.View.Abstract.ControlledViewActivity;
import com.segarra.lucas.teammanagerv2.View.Abstract.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 26/09/2016.
 */

public class HomeActivity extends ControlledViewActivity {
    private static final int CAM_REQ_CO = 1;

    @Override
    public void onCreate(Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.activity_home);
        OptionsFragment optionsFragment=new OptionsFragment().newInstance(controller);
        getFragmentManager().beginTransaction().replace(R.id.f_ops, optionsFragment).addToBackStack(null).commit();
        NewsFragment newsFragment=new NewsFragment().newInstance(controller);
        getFragmentManager().beginTransaction().replace(R.id.f_info,newsFragment).addToBackStack(null).commit();
    }


    //OTHER FRAGMENTS BUTTONS RESPONSE
    public void changePic(View view){
        Intent photoIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(photoIntent.resolveActivity(this.getPackageManager())!=null){
            startActivityForResult(photoIntent,CAM_REQ_CO);
        }
    }
    @Override
    public void onActivityResult(int reqCo,int resCo,Intent data){
        if(reqCo==CAM_REQ_CO){
            if(resCo==RESULT_OK){
                Bundle extras=data.getExtras();
                Bitmap image= (Bitmap) extras.get("data");
                controller.changePicture(image);
            }
        }
    }

    public void showTeams(View view){

    }
    public void newTeam(View view){

    }
    public void leaveTeam(View view){

    }
    public void deleteProfile(View view){

    }

    //OBSERVER METHODS

    @Override
    public void onInvalidLogin() {

    }

    @Override
    public void onInvalidSignUp() {

    }

    @Override
    public void onInvalidCreateTeamName() {

    }

    @Override
    public void onNoTeamUser() {

    }

    @Override
    public void onLogged() {

    }

    @Override
    public void onSigned() {

    }

    @Override
    public void onTeamCreated() {

    }

    @Override
    public void onPictureChanged() {

    }

    @Override
    public void onTeamChanged() {

    }

    @Override
    public void onMatchCreated() {

    }

    @Override
    public void onInvalidEnrollTeamName() {

    }

    @Override
    public void onMyPlayerProfile() {
        PlayerFragment p=new PlayerFragment().newInstance(controller);
        changeRightFragment(p);
    }

    @Override
    public void onMyTeamProfile() {
        TeamFragment t=new TeamFragment().newInstance(controller);
        changeRightFragment(t);
    }

    @Override
    public void onEvents() {
        EventsFragment c=new EventsFragment().newInstance(controller);
        changeRightFragment(c);
    }

    @Override
    public void onTeamSearch() {
        Intent findTeamIntent=new Intent(HomeActivity.this,FindTeamActivity.class);
        Bundle b=getControlledBundle();
        findTeamIntent.putExtras(b);
        startActivity(findTeamIntent);
    }

    @Override
    public void onNewTeam() {

    }

    @Override
    public void onChangesSaved() {

    }

    @Override
    public void update(Observable o, Object arg) {
    }

    private void changeRightFragment(ViewFragment viewFragment){
        getFragmentManager().beginTransaction().replace(R.id.f_info,viewFragment).addToBackStack(null).commit();
    }
}
