package algo_programmers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Heap_Hotter {

    @Test
    public void Heap_순서바꾸기() {
        //given
        ArrayList<Integer> heapList = new ArrayList<>();
        int temp = 0;

        //when
        heapList.add(1);
        heapList.add(3);
        heapList.add(6);

        temp = heapList.get(0);
        heapList.set(0, heapList.get(1));
        heapList.set(1, temp);

        //then
        assertThat(3, is(heapList.get(0)));

    }

    @Test
    public void 힙() {

    }

    private List<Integer> changeHeap (List<Integer> originalList, int parent, int child) {
        int temp = 0;
        temp = originalList.get(0);
        originalList.set(0,originalList.get(1));
        originalList.set(1, temp);
    }
}
