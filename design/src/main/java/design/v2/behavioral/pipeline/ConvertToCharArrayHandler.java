package design.v2.behavioral.pipeline;

import java.util.Arrays;

class ConvertToCharArrayHandler implements Handler<String, char[]> {


    @Override
    public char[] process(String input) {
        char[] characters = input.toCharArray();

        String string = Arrays.toString(characters);

        System.out.println(
                String.format("Current handler: %s, input is %s of type %s, output is %s, of type %s",
                        ConvertToCharArrayHandler.class, input, String.class, string, Character[].class)
        );

        return characters;
    }
}
