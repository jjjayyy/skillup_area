package algo_programmers;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Heap_Hotter {

    List<Integer> heapList;

    @Test
    public void Heap_순서바꾸기() {
        //given
        int temp = 0;

        //when
        heapList.add(1);
        heapList.add(3);
        heapList.add(6);



        //then
        assertThat(3, is(changeHeap(0, 2).get(0)));

    }

    @Test
    public void 힙추가() {
        //given
        int[] arr = {5, 22, 3, 2, 4 ,6, 7};

        //when


        //then


    }

    private List<Integer> changeHeap (int parent, int child) {
        int temp = 0;
        temp = heapList.get(parent);
        heapList.set(parent, heapList.get(child));
        heapList.set(child, temp);

        return heapList;
    }


}
