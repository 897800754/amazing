
/**
 * reader -> process ->writer
 * 不需要 自行装饰 writer
 * public interface ItemProcessor<I, O> {
 * <p>
 * O process(I item) throws Exception;
 * }
 *
 * @author: cg
 * @date: 2022-10-09 00:46
 **/
package cn.cg.batch.item.processing;
