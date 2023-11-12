package design.v2.behavioral.iterator.demo1;


/**
 * @author: cg
 * @date: 2022-10-24 21:51
 **/
public class App {

    public static void main(String[] args) {
        TreasureChest treasureChest = new TreasureChest();

        Iterator<Item> itemIterator = treasureChest.iterator(ItemType.RING);
        while (itemIterator.hasNext()) {
            System.out.println(itemIterator.next().toString());
        }
    }
}
