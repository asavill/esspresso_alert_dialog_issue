import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.espresso_alert_dialog_issue.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1() {


        var dialog: Dialog? = null

        val title = "test title"
        val message = "test message"
        val listener = DialogInterface.OnClickListener { _, which ->  }

        rule.scenario.onActivity {
            dialog = AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("b" + DialogInterface.BUTTON_POSITIVE, listener)
                .setNegativeButton("b" + DialogInterface.BUTTON_NEGATIVE, listener)
                .setNeutralButton("b" + DialogInterface.BUTTON_NEUTRAL, listener).show()
        }

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).inRoot(isDialog()).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).check(doesNotExist())

    }

    @Test
    fun test2() {


        var dialog: Dialog? = null

        val title = "test title"
        val message = "test message"
        val listener = DialogInterface.OnClickListener { _, which ->  }

        rule.scenario.onActivity {
            dialog = AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("b" + DialogInterface.BUTTON_POSITIVE, listener)
                .setNegativeButton("b" + DialogInterface.BUTTON_NEGATIVE, listener)
                .setNeutralButton("b" + DialogInterface.BUTTON_NEUTRAL, listener).show()
        }

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).inRoot(isDialog()).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).check(doesNotExist())

    }
}