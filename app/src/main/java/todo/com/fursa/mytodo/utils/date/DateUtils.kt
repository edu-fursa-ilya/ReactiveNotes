package todo.com.fursa.mytodo.utils.date

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {

    fun format(date: Date?): String {
        var dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return dateFormat.format(date)
    }

    fun getDate(date: Date?): String {
        val dateFormat = SimpleDateFormat("MM-dd-yyyy")
        return dateFormat.format(date)
    }

    fun getTime(date: Date?): String {
        val timeFormat = SimpleDateFormat("HH:mm")
        return timeFormat.format(date)
    }

}