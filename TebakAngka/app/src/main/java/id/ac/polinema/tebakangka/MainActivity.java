package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
	private EditText numberInput;
    private Button guessButton;
    private int randomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numberInput = findViewById(R.id.number_input);
        guessButton = findViewById(R.id.guess_button);
        initRandomNumber();
	}

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"App on Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"App on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"App on Restart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"App on Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"App on Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"App on Destroy", Toast.LENGTH_SHORT).show();
    }

	private void initRandomNumber()
    {
        Random rand = new Random();
        int min = 1;
        int max = 100;
        randomNumber = rand.nextInt(max - min) + min;
	}

	public void handleGuess(View view)
    {
        int inputNumber = Integer.parseInt(numberInput.getText().toString());
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        if(inputNumber == randomNumber)
        {
            alertDialogBuilder.setMessage("Tebakan Anda benar!");
            guessButton.setEnabled(false);
        }
        else if(inputNumber > randomNumber)
        {
            alertDialogBuilder.setMessage("Tebakan Anda terlalu besar!");
        }
        else if(inputNumber < randomNumber)
        {
            alertDialogBuilder.setMessage("Tebakan Anda terlalu kecil!");
        }

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
	}

	public void handleReset(View view)
    {
        numberInput.setText("");
        guessButton.setEnabled(true);
        initRandomNumber();
    }

}
