package SecondSem.Informatics.Lesson_2;

public class List<T extends Number> {
   private ListElement<T> head;

    public List(ListElement<T> head) {
        this.head = head;
    }

    public List(T value){
        this.head = new ListElement<>(value);
    }

    public ListElement<T> getHead(){
        return head;
    }

    public int size(){
        ListElement<T> elem = head;
        int count = 0;
        while (elem != null){
            elem = elem.getNext();
            count++;
        }
        return count;
    }

    public ListElement<T> get(int index){
        if (index < size()){
            ListElement<T> elem = head;
            for (int i = 0; i < index; i++){
                elem = elem.getNext();
            }
            return elem;
        }
        return null;
    }

    public ListElement<T> findValue(T value){
        ListElement<T> elem = head;
        while (!elem.getValue().equals(value)){
            elem = elem.getNext();
        }
        return elem;
    }

    public void add(ListElement<T> elem, int index){
        ListElement<T> element = get(index);
        elem.setNext(element.getNext());
        element.setNext(elem);
    }

    public void add(T value, int index){
        add(new ListElement<>(value), index);
    }

    public void push(ListElement<T> element){
        add(element, size() - 1);
    }

    public void push(T value){
        push(new ListElement<>(value));
    }

    private void deleteNextElem(ListElement<T> element){
        ListElement<T> prev = head;
        ListElement<T> curr = head.getNext();
        while (!(curr.getValue().equals(element.getValue()))){
            prev = prev.getNext();
            curr = curr.getNext();
        }
        prev = prev.getNext();
        curr = curr.getNext();
        if (curr != null){
            deleteElement(prev, curr);
        }
    }

    public void deleteNextElem(int index){
        if (index == -1){
            deleteHead();
        } else {
            deleteNextElem(get(index));
        }
    }

    private void deleteElement(ListElement prev, ListElement curr){
        prev.setNext(curr.getNext());
        curr.setNext(null);
    }

    public void deleteHead(){
       ListElement<T> nextHead  = head.getNext();
       head.setNext(null);
       this.head = nextHead;
    }

    public void joint(List list){
        ListElement<T> elem = list.getHead();
        while (elem != null){
            this.push(new ListElement<>(elem.getValue()));
            elem = elem.getNext();
        }
    }

    public void printList(){
        for (int i = 0; i < size(); i++){
            System.out.println(get(i));
        }
    }
}