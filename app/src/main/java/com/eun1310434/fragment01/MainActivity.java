/*=====================================================================
06.03.2018
eun1310434@naver.com
https://blog.naver.com/eun1310434
참고) Do it android app programming
=====================================================================*/
package com.eun1310434.fragment01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트를 코드에서 추가
        fragmentA = new FragmentA();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentA).commit();//트렌젝션 안에서의 실행이므로 commit을 꼭해줘야 함

        fragmentB = new FragmentB();
    }

    //프래그먼트 변경 시
    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentB).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentA).commit();
        }
    }

}
