package org.example;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Сохраняем ссылку на следующий элемент
            current.next = prev; // Меняем указатель на следующий элемент на предыдущий
            prev = current; // Перемещаем указатель prev на текущий элемент
            current = next; // Перемещаем указатель current на следующий элемент
        }

        return prev; // Новая голова списка после разворота
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создаем список: 1 -> 2 -> 3 -> 4 -> 5
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);

        System.out.println("Исходный список:");
        printList(head);

        // Разворачиваем список
        head = reverse(head);

        System.out.println("Список после разворота:");
        printList(head);
    }

    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1); // Создаем фиктивный узел
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }
}

