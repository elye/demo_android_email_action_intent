package com.elyeproj.emailtest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_one.setOnClickListener {
            val addresses = listOf("fake@address.com", "some@add.com").toTypedArray()
            val subject = "Some title"
            val text = "Some message\n\nNew Line\n\n"
            mailtoTypeEmailCreation(addresses, subject, text)
        }

        button_two.setOnClickListener {
            val addresses = listOf("fake@address.com", "some@add.com").toTypedArray()
            val subject = "Some title"
            val text = "Some message\n\nNew Line\n\n"
            latestExampleEmailCreation(addresses, subject, text)
        }

        button_three.setOnClickListener {
            val addresses = listOf("fake@address.com", "some@add.com").toTypedArray()
            val subject = "Some title"
            val text = "Some message\n\nNew Line\n\n"
            intentDataEmailCreation(addresses, subject, text)
        }

        button_four.setOnClickListener {
            val addresses = listOf("fake@address.com", "some@add.com").toTypedArray()
            val subject = "Some title"
            val text = "Some message<br><br>New Line<br><br>"
            intentDataEmailCreation(addresses, subject, text)
        }
    }

    private fun mailtoTypeEmailCreation(addresses: Array<String>, subject: String, text: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            val mailto = "mailto:" + addresses.joinToString(",")
            data = Uri.parse(mailto)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, text)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun latestExampleEmailCreation(addresses: Array<String>, subject: String, text: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, text)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun intentDataEmailCreation(addresses: Array<String>, subject: String, text: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            val uriText = String.format("mailto:%s?subject=%s&body=%s",
                addresses.joinToString(","), subject, text)
            data = Uri.parse(uriText)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
