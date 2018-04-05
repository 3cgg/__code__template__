package me.libme.webseed.fn._template.ftl;

import java.io.IOException;
import java.io.OutputStream;

public class MessageStream extends OutputStream {

    private OutputStream outputStream=System.out;

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

}
