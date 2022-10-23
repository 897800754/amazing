package design.v2.behavioral.pipeline;

interface Handler<I, O> {
  O process(I input);
}
