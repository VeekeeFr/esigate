/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.esigate.esi;

import java.io.IOException;
import java.io.StringWriter;

import junit.framework.TestCase;

import org.esigate.HttpErrorPage;
import org.esigate.MockRequestExecutor;
import org.esigate.impl.DriverRequest;
import org.esigate.test.TestUtils;

public class RemoveElementTest extends TestCase {
    private DriverRequest request;

    @Override
    protected void setUp() throws Exception {
        MockRequestExecutor provider = MockRequestExecutor.createMockDriver();
        request = TestUtils.createRequest(provider.getDriver());
    }

    public void testRemove() throws IOException, HttpErrorPage {
        String page = "begin <esi:remove>some text to be removed</esi:remove> end";
        EsiRenderer tested = new EsiRenderer();
        StringWriter out = new StringWriter();
        tested.render(request, page, out);
        assertEquals("begin  end", out.toString());
    }

}
