package com.hatanian.twitter.command.viewtimeline;

import com.hatanian.twitter.output.Output;
import com.hatanian.twitter.domain.User;
import com.hatanian.twitter.persistence.PostRepository;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class ViewTimelineCommandFactoryTest {

    @Test
    public void shouldBuildViewTimelineCommand() throws Exception {
        PostRepository mockPostRepository = mock(PostRepository.class);
        User mockUser = mock(User.class);
        Output mockOutput = mock(Output.class);
        ViewTimelineCommand viewTimelineCommand = new ViewTimelineCommandFactory(mockPostRepository, mockOutput).buildViewTimelineCommand(mockUser);
        assertThat(viewTimelineCommand).isEqualTo(new ViewTimelineCommand(mockPostRepository, mockUser, mockOutput));
    }


}