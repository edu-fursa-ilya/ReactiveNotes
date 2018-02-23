package todo.com.fursa.mytodo.ui.recycler

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.todo_item.view.*
import todo.com.fursa.mytodo.R
import todo.com.fursa.mytodo.data.model.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private lateinit var mTodoList: List<Todo>

    fun setDataSource(mTodoList: List<Todo>) {
        this.mTodoList = mTodoList
    }

    override fun getItemCount() = mTodoList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder?, position: Int) {
        holder!!.bind(mTodoList[position])
    }

    class TodoViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View?) {
            Toast.makeText(p0!!.context, "Clicked = ${p0.title.text}", Toast.LENGTH_SHORT).show()
        }

        private var mTitle: TextView? = itemView!!.findViewById(R.id.title)
        private var mText: TextView? = itemView!!.findViewById(R.id.text)
        private var mTodoItem: CardView? = itemView!!.findViewById(R.id.todo_item)

        fun bind(todo: Todo) {
            mTitle!!.text = todo.todoTitle
            mText!!.text = todo.todoText
            mTodoItem!!.setOnClickListener(this)
        }
    }
}
