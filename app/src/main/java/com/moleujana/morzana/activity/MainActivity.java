package com.moleujana.morzana.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.moleujana.morzana.APIClient;
import com.moleujana.morzana.APIService;
import com.moleujana.morzana.R;
import com.moleujana.morzana.mrzn.Message;
import com.moleujana.morzana.mrzn.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    APIService apiService;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        apiService = APIClient.getClient().create(APIService.class);

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Register() {

        Call<User> call = apiService.register(new User());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    // 회원 가입 성공
                } else {
                    // 실패
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // 실패
            }
        });
    }

    public void Login() {

        Call<User> call = apiService.register(new User());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int statu = response.code();
                if (statu == 0) {
                    // 로그인 성공
                } else if (statu == -1) {
                    // 존재하지 않는 아이디
                } else if (statu == -2) {
                    // 비밀번호 틀림
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // 실패
            }
        });
    }

    public void idCheck() {
        Call<User> call = apiService.idCheck("");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                int statu = response.code();
                if (statu == 0) {
                    // 아이디 중복 X
                } else if (statu == -1) {
                    // 중복
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void joinedUser() {
        Call<List<User>> call = apiService.joinedUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.body() != null) {
                    List<User> userList = response.body();
                } else {
                    // 가입된 회원 없음
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public void sendMessage() {
        Call<Message> call = apiService.sendMessage(new Message());
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if (response.isSuccessful()) {
                    // 보내기 성공
                } else {
                    // 실패
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }

    public void sendMessageList() {

        Call<List<Message>> call = apiService.sendMessageList(0);
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.body() != null) {
                    List<Message> messageList = response.body();
                } else {
                    // 보낸 메시지 없음
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }

    public void receiveMessageList() {
        Call<List<Message>> call = apiService.receiveMessageList(0);
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.body() != null) {
                    List<Message> messageList = response.body();
                } else {
                    // 받은 메시지 없음
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }
}
