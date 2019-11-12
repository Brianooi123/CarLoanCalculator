package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reset =findViewById<Button>(R.id.buttonReset)
        val cal = findViewById<Button>(R.id.buttonCalculate)
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate)
        cal.setOnClickListener(View.OnClickListener {
            val carLoan  = (carPrice.text.toString().toInt()-downPayment.text.toString().toInt()).toString()
            val interest =(carLoan.toInt()*interestRate.text.toString().toDouble()*loanPeriod.text.toString().toInt()).toString()
            val monthlyRepayment =((carLoan.toInt()+interest.toDouble())/loanPeriod.text.toString().toInt()/12).toString()

            textViewLoan.setText("Loan:"+carLoan)
            textViewInterest.setText("Interest"+interest)
            textViewMonthlyRepayment.setText("Monthly Repayment:"+monthlyRepayment)
        })
        reset.setOnClickListener(View.OnClickListener {
            textViewMonthlyRepayment.setText("Monthly Repayment:")
            textViewInterest.setText("Interest:")
            textViewLoan.setText("Loan:")
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextInterestRate.text.clear()
            editTextLoanPeriod.text.clear()
        })
    }

}
