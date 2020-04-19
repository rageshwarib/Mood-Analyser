package com.BridgeLabz.moodAnalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_whenGetMood_ShouldReturnsadMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Sad", mood);
    }
    @Test
    public void givenHappyMessge_whenGetMood_shouldReturnhappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);
    }
    @Test
    public void whenGetAnyMood_shouldReturnhappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);

    }
    @Test
    public void givenNullMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException){
            Assert.assertEquals("Invalid Message", moodAnalysisException.getMessage());
        }
    }
    @Test
    public void givenEmptyMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(" ");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty Mood",moodAnalysisException.getMessage());
        }
    }
    @Test
    public void givenMoodAnalyserClassName_whenInProper_shouldReturnObject() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserObj = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObj);
        Assert.assertEquals(true, check);
    }

    @Test
    public void givenMoodAnalyserClassName_whenImproper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            MoodAnalyserFactory.getConstructor("MoodeAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassName_whenConstructorNotProper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException,InvocationTargetException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
}

    @Test
    public void givenMoodAnalyserClassName_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }
    @Test
    public void givenMoodAnalyserWithParameterConstructor_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createMoodAnalyserObject(moodAnalyserConstructor, "I am in Happy mood");
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }
    @Test
    public void givenMoodAnalysrClassName_whenImproper_shouldThrowMoodAnalysisException(){
        try {
             MoodAnalyserFactory.getConstructor("MoodeAnalyser");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }
    @Test
    public void givenMoodAnalysrClassName_whenConstructorNotProper_shouldThrowMoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
      }
    }
}
