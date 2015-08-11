package dsquare.hiselfies.selfieworld;

/**
 * Created by Dsquare-2 on 10-08-2015.
 */
public class CustomSelfieWorld {
    int resId1=0;
    int resId2=0;
    public CustomSelfieWorld(){
    }
    public CustomSelfieWorld(int resId1,int resId2,int resId3){
        this.resId1=resId1;
        this.resId2=resId2;
    }
    public int getResId1(){
        return this.resId1;
    }
    public int getResId2(){
        return this.resId2;
    }
}
