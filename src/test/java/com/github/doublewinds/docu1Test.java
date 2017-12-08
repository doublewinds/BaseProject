package com.github.doublewinds;

import org.junit.Test;

import org.junit.Assert;

public class docu1Test {
    @Test
    public void getType() throws Exception {
        // Arrange
        docu1 triangle = new docu1(5, 10, 5);

        // Act
        String result = triangle.getType();

        // Assert
        Assert.assertEquals("不是三角形", result);
    }
}

