package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.output.PostFormatter;
import com.hatanian.twitter.persistence.PostRepository;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.output.Output;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ViewTimelineCommandFactoryTest {
    @Mock
    PostRepository mockPostRepository;

    @Mock
    Output mockOutput;

    @Mock
    PostFormatter mockPostFormatter;

    @Test
    public void shouldCreateViewTimelineCommand() throws Exception {
        ViewTimelineCommand viewTimelineCommand = new ViewTimelineCommandFactory(mockPostRepository, mockOutput, mockPostFormatter).createViewTimelineCommand("Alice");
        assertThat(viewTimelineCommand).isEqualTo(new ViewTimelineCommand(mockPostRepository, new User("Alice"), mockOutput, mockPostFormatter));
    }
}