public class Exercise17 {

    /*
    Write a method called removeRange that accepts a starting and ending index as parameters and removes the
elements at those indexes (inclusive) from the list. For example, if a variable list stores the values [8, 13, 17,
4, 9, 12, 98, 41, 7, 23, 0, 92], the call of listRange.removeRange(3, 8); should remove values
between index 3 and index 8 (the values 4 and 7), leaving the list of [8, 13, 17, 23, 0, 92]. The method
Programming Projects 1029
should throw an IllegalArgumentException if either of the positions is negative. Otherwise you may assume
that the positions represent a legal range of the list (0  start  end  size).
     */
    public static void main(String[] args) {
        LinkedIntList liste1 = new LinkedIntList();

        liste1.add(77);
        liste1.add(1);
        liste1.add(3);
        liste1.add(4);
        liste1.add(6);
        liste1.add(7);
        liste1.add(9);
        liste1.add(10);
        liste1.add(12);
        liste1.add(13);
        liste1.add(15);
        liste1.add(16);

        System.out.println("List : " + liste1);

        liste1.removeRange(1,10);
        System.out.println("\n After the removial u get this list: " + liste1);

    }
}

class List
{
    public int data;
    public List next;

    public List ()
    {
        this(0,null);
    }

    public List(int data) {
        this(data,null);
    }

    public List(int data, List next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedIntList {
    private List front;

    public LinkedIntList() {
        front = null;
    }

    public int size() {
        int count = 0;
        List current = front;

        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            List current = front.next;

            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "] ";
            return result;
        }
    }

    public void add(int value) {
        if (front == null) {
            front = new List(value);
        } else {
            List current = front;

            while (current.next != null) {
                current = current.next;
            }
            current.next = new List(value);
        }
    }

    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            List current = node(index - 1);
            current.next = current.next.next;
        }
    }

    private List node(int index) {
        List current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void removeRange(int stIndex, int enIndex)
    {
        if(stIndex < 0 || enIndex < 0)
        {
            System.out.println("U cant do that!");
            throw new IllegalArgumentException();
        }
        else if(stIndex >= 0 && enIndex < size())
        {
            for (int i = stIndex; i <= enIndex ; i++) {
                remove(stIndex);
            }
        }
        else
        {
            System.out.println("Please enter the right range: ");
            System.exit(0);
        }
    }
}
