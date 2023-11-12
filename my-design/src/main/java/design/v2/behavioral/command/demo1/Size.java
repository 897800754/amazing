package design.v2.behavioral.command.demo1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Size {

    SMALL("small"),
    NORMAL("normal");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}
