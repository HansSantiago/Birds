package com.co.ias.Birds.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);

}
