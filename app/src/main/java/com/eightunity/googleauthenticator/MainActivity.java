package com.eightunity.googleauthenticator;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eightunity.googleauthenticator.authenticator.AuthenticatorConstant;
import com.eightunity.googleauthenticator.authenticator.LoginActivity;
import com.eightunity.googleauthenticator.authenticator.LoginActivityX;

public class MainActivity extends AppCompatActivity {

    private AccountManager accountManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountManager = AccountManager.get(this);
        if (isAuthen()) {
        }
    }

    private boolean isAuthen() {
        if (getAccount() == null) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivityForResult(intent, 1);
            return false;
        } else {
            return true;
        }
    }

    private Account getAccount() {
        AccountManager am = AccountManager.get(this);
        Account [] accounts = am.getAccountsByType(AuthenticatorConstant.GOOGLE_ACCOUNTYTPE);

        if (accounts.length > 0) {
            return accounts[0];
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
