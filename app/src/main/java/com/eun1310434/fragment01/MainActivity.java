/*=====================================================================
□ Infomation
  ○ Data : 24.05.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : Do it android app Programming

□ Function
  ○ Fragment

□ Study
  ○
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
        // 액티비티에서 프래그먼트를 사용하는 경우 특히 유용한 점은 사용자 상호작용에 응답하여 추가, 제거, 교체 및 다른 작업을 수행할 수 있다는 것입니다.
        // 액티비티에 커밋한 변경 내용의 집합을 트랜잭션이라고 하며,
        // 이것을 수행하려면 FragmentTransaction 내의 API를 사용하면 됩니다.
        // 해당 액티비티가 관리하는 백 스택에 행해진 각 트랜잭션을 저장할 수도 있습니다.
        // 이렇게 하면 사용자가 프래그먼트 변경 내역을 거쳐 뒤로 탐색할 수 있습니다(액티비티를 통과해 뒤로 탐색하는 것과 비슷합니다).


        fragmentB = new FragmentB();
    }

    //프래그먼트 변경 시
    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentB).addToBackStack(null).commit();
            //If you add multiple changes to the transaction—such as another add() or remove()—and call addToBackStack(),
            // then all changes applied before you call commit() are added to the back stack as a single transaction
            // and the Back button reverses them all together.
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentA).addToBackStack(null).commit();
        }
    }

}
