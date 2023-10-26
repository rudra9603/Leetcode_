//https://leetcode.com/problems/copy-list-with-random-pointer/description/

public class Copy_List_with_Random_Pointer {

        public Node copyRandomList(Node head) {

            if (head == null)
                return head;


            Node curr = head;

            while (curr != null) {

                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = newNode.next;
            }

            curr = head;
            Node temp = curr.next;

            while (curr != null) {
                if (curr.random == null) {

                    temp.random = null;
                } else {

                    temp.random = curr.random.next;
                }


                curr = temp.next;


                if (temp.next != null) {
                    temp = temp.next.next;
                }
            }

            curr = head;
            temp = head.next;
            Node ans = temp;

            while (curr != null) {
                curr.next = curr.next.next;


                if (temp.next != null) {
                    temp.next = curr.next.next;
                }


                curr = curr.next;
                temp = temp.next;
            }

            return ans;
        }
    }

