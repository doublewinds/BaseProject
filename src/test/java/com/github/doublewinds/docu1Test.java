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
    public void getType1() throws Exception {
        // Arrange
        docu1 triangle = new docu1(3, 4, 5);

        // Act
        String result = triangle.getType();

        // Assert
        Assert.assertEquals("直角三角形", result);
    }
    public void getType2() throws Exception {
        // Arrange
        docu1 triangle = new docu1(3, 4, 4);

        // Act
        String result = triangle.getType();

        // Assert
        Assert.assertEquals("銳角三角形", result);
    }
    public void getType3() throws Exception {
        // Arrange
        docu1 triangle = new docu1(7, 4, 4);

        // Act
        String result = triangle.getType();

        // Assert
        Assert.assertEquals("鈍角三角形", result);
    }
}

