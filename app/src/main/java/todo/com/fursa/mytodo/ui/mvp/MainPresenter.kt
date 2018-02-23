package todo.com.fursa.mytodo.ui.mvp

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Flowable
import todo.com.fursa.mytodo.data.model.Todo
import todo.com.fursa.mytodo.data.room.TodoDAO
import todo.com.fursa.mytodo.utils.TodoApplication
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<IMainView>(){
    init {
        TodoApplication.component.inject(this)
    }

    @Inject
    lateinit var todoDAO: TodoDAO

    fun addNewNote(todo: Todo) {
        todoDAO.save(todo)
    }

    fun loadAllNotes() {
        val notesList: Flowable<List<Todo>> = todoDAO.selectAll()
        viewState.hideEmptyListMessage()
        viewState.onNotesLoaded(notesList)
        viewState.showNotesList()
    }
}



