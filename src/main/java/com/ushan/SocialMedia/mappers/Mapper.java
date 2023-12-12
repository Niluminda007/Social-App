package com.ushan.SocialMedia.mappers;

public interface Mapper<A,B> {
    B mapTo(A a);
    A mapFrom(B b);

}
