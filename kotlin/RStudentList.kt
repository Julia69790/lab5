 import data.Student
 import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.*
import react.dom.li
import react.dom.ol
import react.dom.span

interface RStudentListProps : RProps {
    var students: Array<Student>
    var present: Array<Boolean>
    var onClick:List<(Event)->Unit>
}
val RFStudentList =
    functionalComponent<RStudentListProps> {
        ol {
            it.students.mapIndexed { index, student ->
                li {
                    rstudent(student, it.present[index], it.onClick[index])
                }
            }
        }
    }

        fun RBuilder.studentList(students:Array<Student>, present: Array<Boolean>, onClick:List<(Event)->Unit>) =
            child(RFStudentList) {
                attrs.students = students
                attrs.present = present
                attrs.onClick = onClick
            }