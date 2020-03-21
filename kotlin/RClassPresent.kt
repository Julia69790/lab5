import data.Lesson
import data.Student
import data.studentList
import org.w3c.dom.events.Event
import react.*
import react.dom.h2
import react.dom.li
import react.dom.ol

interface RClassPresentProps : RProps {
    var students: Array<Student>
    var lesson:Lesson
}
interface RClassPresentState: RState{
    var present: Array<Boolean>
}

class RClassPresent: RComponent<RClassPresentProps, RClassPresentState>() {

    override fun componentWillMount() {
        state.apply {
            present = Array(props.students.size) { false }
        }
    }

    fun onClick(index:Int): (Event) -> Unit = {
        setState {
            state.present[index] = !state.present[index]
        }
    }

    override fun RBuilder.render() {
        val click = props.students.mapIndexed { index, student -> onClick(index) }
          h2{ + props.lesson.name}
            studentList(props.students, state.present, click)
    }
}

     fun RBuilder.classPresent(students: Array<Student>,lesson:Lesson ) =
        child(RClassPresent::class) {
            attrs.students = students
            attrs.lesson = lesson
        }


