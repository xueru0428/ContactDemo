package contactdemo.contactdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Person> persons;
    private TextView tv_main_word;

    private IndexView iv_main_words;
    private Myadapter adapter;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = (ListView) findViewById(R.id.listView);
        iv_main_words = (IndexView) findViewById(R.id.iv_main_words);
//        tv_main_word = (TextView) findViewById(R.id.tv_main_word);

        initData();
        adapter = new Myadapter();

        listView.setAdapter(adapter);
        //设置监听
        MyOnIndexChangeListener myOnIndexChangeListener = new MyOnIndexChangeListener();

        iv_main_words.setOnIndexChangeListerent(myOnIndexChangeListener);
    }
    //接口的实现类
    class MyOnIndexChangeListener implements IndexView.onIndexChangeListerent {

        @Override
        public void onIndeChange(String word) {
//            updateWord(word);
//            updatelist(word);
        }
    }

//    private void updatelist(String word) {
//        for (int i = 0 ;i <persons.size();i++){
//            String listwords = persons.get(i).getPinyin().substring(0,1);
//            //传入一个index整型数值，就可以让ListView定位到指定Item的位置。
//            if(word.equals(listwords)) {
//                listView.setSelection(i);
//                return;
//            }
//        }
//    }

//    private void updateWord(String word) {
//        tv_main_word.setText(word);
//        tv_main_word.setVisibility(View.VISIBLE);
//        handler.removeCallbacksAndMessages(null);
//        /**
//         * 这个方法是说handler发个两秒的消息  两秒后再执行Runnable的对象
//         * 使用PostDelayed方法，两秒后调用此Runnable对象
//         * handler.postDelayed(runnable, 2000);
//         * 实际上也就实现了一个2s的一个定时器
//         */
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tv_main_word.setVisibility(View.GONE);
//            }
//        }, 2000);
//    }

    public class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return persons.size();
        }

        @Override
        public Object getItem(int i) {
            return persons.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null) {
                convertView = View.inflate(MainActivity.this,R.layout.idex_view,null);
                viewHolder = new ViewHolder();
                viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tv_word = (TextView) convertView.findViewById(R.id.tv_word);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Person person = persons.get(position);
            String ll = person.getPinyin().substring(0,1);
            //Log.e("tag","dddddddddddddddddddd="+viewHolder);
            viewHolder.tv_word.setText(ll);
            //  Log.e("tag","dddddddddddddddddddd="+viewHolder.tv_word);
            viewHolder.tv_name.setText(person.getName());
            if(position==0) {
                viewHolder.tv_word.setVisibility(View.VISIBLE);

            }else {
                String preword = persons.get(position-1).getPinyin().substring(0,1);
                if(preword.equals(ll)) {
                    viewHolder.tv_word.setVisibility(View.GONE);
                }else{
                    viewHolder.tv_word.setVisibility(View.VISIBLE);
                }
            }
            return convertView;
        }
        class ViewHolder{
            TextView tv_word;
            TextView tv_name;
        }

    }

    private void initData() {
        persons = new ArrayList<>();
        persons.add(new Person("张晓飞"));
        persons.add(new Person("杨光福"));
        persons.add(new Person("胡继群"));
        persons.add(new Person("刘畅"));

        persons.add(new Person("钟泽兴"));
        persons.add(new Person("尹革新"));
        persons.add(new Person("安传鑫"));
        persons.add(new Person("张骞壬"));

        persons.add(new Person("温松"));
        persons.add(new Person("李凤秋"));
        persons.add(new Person("刘甫"));
        persons.add(new Person("娄全超"));
        persons.add(new Person("张猛"));

        persons.add(new Person("王英杰"));
        persons.add(new Person("李振南"));
        persons.add(new Person("孙仁政"));
        persons.add(new Person("唐春雷"));
        persons.add(new Person("牛鹏伟"));
        persons.add(new Person("姜宇航"));

        persons.add(new Person("刘挺"));
        persons.add(new Person("张洪瑞"));
        persons.add(new Person("张建忠"));
        persons.add(new Person("侯亚帅"));
        persons.add(new Person("刘帅"));

        persons.add(new Person("乔竞飞"));
        persons.add(new Person("徐雨健"));
        persons.add(new Person("吴亮"));
        persons.add(new Person("王兆霖"));

        persons.add(new Person("阿三"));
        persons.add(new Person("李岩"));
        persons.add(new Person("王瑞"));


        //排序
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });

    }

}
