class Element {
    public int val;
    public Element next;

    public Element(int val) {
        this.val = val;
        this.next = null;
    }

    public Element(int val, Element next) {
        this.val = val;
        this.next = next;
    }
}

class Anchor {
    public Element first;

    public Anchor() {
        first = null;
    }

    public void insertAtTheFront(int x) {
        if (first == null) {
            first = new Element(x);
        }
        else {
            first = new Element(x,first);
        }
    }

    public void insertAtTheEnd(int x) {
        if (first == null) {
            first = new Element(x);
        }
        else {
            Element tmp = first;
            while (!(tmp.next == null)) {
                tmp = tmp.next;
            }
            tmp.next = new Element(x);
        }
    }

    public void removeFirst() {
        if (first == null) ;
        else {
            Element tmp = first;
            if (first.next == null) first = null;
            else {
                first = first.next;
                tmp = null;
            }
        }
    }

    public void removeLast() {
        if (first == null) ;
        else {
            if (first.next == null) first = null;
            else {
                Element tmp = first;
                while (tmp.next != null && tmp.next.next != null) tmp = tmp.next;
                tmp.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (first == null) {
            stringBuilder.append("Empty List!!!");
        }
        else {
            stringBuilder.append("List: ");
            Element tmp = first;
            while (!(tmp.next == null)) {
                stringBuilder.append(tmp.val);
                stringBuilder.append(", ");
                tmp = tmp.next;
            }
            stringBuilder.append(tmp.val);
            stringBuilder.append(".");
        }

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        else if (obj instanceof Anchor == false) return false;
        else {
            Anchor tmp = (Anchor) obj;
            if (this.first == null && tmp.first == null) return true;
            else if (this.first == null && tmp.first != null) return false;
            else if (this.first != null && tmp.first == null) return false;
            else {
                Element element1 = this.first;
                Element element2 = tmp.first;
                while (element1.next != null && element2.next != null) {
                    if (element1.val != element2.val) return false;
                    else {
                        element1 = element1.next;
                        element2 = element2.next;
                    }
                }
                if (element1.val != element2.val) return false;
                else {
                    if (element1.next == null && element2.next == null) return true;
                    else return false;
                }
            }
        }
    }
}

public class MyList {
    public Anchor anchor;

    public MyList() {
        anchor = new Anchor();
    }

    public static void main(String[] args) {
        MyList list1 = new MyList();
        MyList list2 = new MyList();
        MyList list3 = new MyList();
        System.out.println(list1.anchor.equals(list2.anchor));
        list1.anchor.insertAtTheFront(2);
        list1.anchor.insertAtTheFront(1);
        list1.anchor.insertAtTheEnd(3);
        System.out.println(list1.anchor.equals(list2.anchor));
        System.out.println(list1.anchor);
        System.out.println(list2.anchor);
        list2.anchor.insertAtTheEnd(5);
        System.out.println(list2.anchor);
        list2.anchor.insertAtTheFront(4);
        System.out.println(list2.anchor);
        list3.anchor.insertAtTheEnd(1);
        list3.anchor.insertAtTheEnd(2);
        list3.anchor.insertAtTheEnd(3);
        list3.anchor.insertAtTheEnd(4);
        list3.anchor.insertAtTheFront(0);
        System.out.println(list3.anchor);
        list3.anchor.removeFirst();
        System.out.println(list3.anchor);
        list3.anchor.removeLast();
        System.out.println(list3.anchor);
        System.out.println(list1.anchor.equals(list1.anchor));
        System.out.println(list1.anchor.equals(list2.anchor));
        System.out.println(list1.anchor.equals(list3.anchor));
        list3.anchor.insertAtTheEnd(4);
        System.out.println(list3.anchor);
        System.out.println(list1.anchor.equals(list3.anchor));
    }
}
