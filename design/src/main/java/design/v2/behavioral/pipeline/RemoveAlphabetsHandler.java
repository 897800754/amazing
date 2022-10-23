package design.v2.behavioral.pipeline;

import java.util.function.IntPredicate;

/**
 * Stage handler that returns a new instance of String without the alphabet characters of the input
 * string.
 */
class RemoveAlphabetsHandler implements Handler<String, String> {


    @Override
    public String process(String input) {
        StringBuilder inputWithoutAlphabets = new StringBuilder();
        IntPredicate isAlphabetic = (IntPredicate) Character::isAlphabetic;
        input.chars()
                .filter(isAlphabetic.negate())
                .mapToObj(x -> (char) x)
                .forEachOrdered(inputWithoutAlphabets::append);

        String inputWithoutAlphabetsStr = inputWithoutAlphabets.toString();
        System.out.println(
                String.format(
                        "Current handler: %s, input is %s of type %s, output is %s, of type %s",
                        RemoveAlphabetsHandler.class, input,
                        String.class, inputWithoutAlphabetsStr, String.class
                )
        );

        return inputWithoutAlphabetsStr;
    }
}
