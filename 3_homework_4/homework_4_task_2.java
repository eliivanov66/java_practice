
// Реализуйте очередь с помощью LinkedList со следующими методами: 
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя

public class homework_4_task_2 {
    public static void main(String[] args) {
        myLinkedList inData = new myLinkedList();
        inData.enqueue("first");  //пример enqueue
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));
        inData.enqueue("second"); //пример enqueue
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));
        inData.enqueue("third");  //пример enqueue
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));
        inData.enqueue("fourth"); //пример enqueue
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));
        System.out.println(String.format("Первый элемент в очереди через dequeue(): %s", inData.dequeue())); //пример dequeue
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));
        System.out.println(String.format("Первый элемент в очереди через first(): %s", inData.first())); //пример first
        System.out.println(String.format("Текущее состояние очереди: %s", inData.toString()));

    }
}

