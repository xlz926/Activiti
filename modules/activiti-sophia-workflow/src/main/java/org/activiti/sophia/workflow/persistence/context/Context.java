/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.sophia.workflow.persistence.context;

import java.util.Stack;

import org.activiti.sophia.workflow.persistence.cfg.WorkflowConfigImpl;
import org.activiti.sophia.workflow.persistence.interceptor.CommandContext;



/**
 * @author Tom Baeyens
 * @author Daniel Meyer
 */
public class Context {

  protected static ThreadLocal<Stack<CommandContext>> commandContextThreadLocal = new ThreadLocal<Stack<CommandContext>>();
  protected static ThreadLocal<Stack<WorkflowConfigImpl>> workflowConfigImplThreadLocal = new ThreadLocal<Stack<WorkflowConfigImpl>>();
  protected static ThreadLocal<Stack<ExecutionContext>> executionContextStackThreadLocal = new ThreadLocal<Stack<ExecutionContext>>();

  public static CommandContext getCommandContext() {
    Stack<CommandContext> stack = getStack(commandContextThreadLocal);
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }

  public static void setCommandContext(CommandContext commandContext) {
    getStack(commandContextThreadLocal).push(commandContext);
  }

  public static void removeCommandContext() {
    getStack(commandContextThreadLocal).pop();
  }

  public static WorkflowConfigImpl getWorkflowConfiguration() {
    Stack<WorkflowConfigImpl> stack = getStack(workflowConfigImplThreadLocal);
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }

  public static void setProcessEngineConfiguration(WorkflowConfigImpl workflowConfiguration) {
    getStack(workflowConfigImplThreadLocal).push(workflowConfiguration);
  }

  public static void removeWorkflowConfiguration() {
    getStack(workflowConfigImplThreadLocal).pop();
  }

  public static ExecutionContext getExecutionContext() {
    return getStack(executionContextStackThreadLocal).peek();
  }


  public static void removeExecutionContext() {
    getStack(executionContextStackThreadLocal).pop();
  }

  protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> threadLocal) {
    Stack<T> stack = threadLocal.get();
    if (stack==null) {
      stack = new Stack<T>();
      threadLocal.set(stack);
    }
    return stack;
  }
  
  
}
