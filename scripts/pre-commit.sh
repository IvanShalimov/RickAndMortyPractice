#!/bin/sh

# Function to check the current branch
check_current_branch() {
  echo "\n🚀 Checking the current git branch..."
  CURRENT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
  if [ "$CURRENT_BRANCH" = "master" ] || [ "$CURRENT_BRANCH" = "develop" ]; then
      echo "🛑 Hold it right there! Committing directly to the '$CURRENT_BRANCH' branch? That's a big no-no!"
      echo "🚫 Direct commits to '$CURRENT_BRANCH' are like trying to use a wrench to write code—doesn't work! 😜"
      echo "\nABORTING COMMIT: You must navigate to a feature branch or create a new one to save the day! 🦸‍♂️🦸‍♀️\n"
      exit 1
  else
      echo "✅ Fantastic! You're on the '$CURRENT_BRANCH' branch, which is perfect for commits. Let's keep this awesome momentum going! 🚀✨"
  fi
}

# Function to run Detekt checks
run_detekt_checks() {
  echo "\n🚀 Detekt is now analyzing your Kotlin code for potential issues!"
  ./gradlew detekt > /tmp/detekt-result
  DETEKT_EXIT_CODE=$?

  if [ ${DETEKT_EXIT_CODE} -ne 0 ]; then
      cat /tmp/detekt-result
      rm /tmp/detekt-result
      echo "\n*********************************************************************************"
      echo "     💥 Oh no! Detekt found issues in the code! Time to fix those issues! 💥"
      echo "     💡 Tip: Review the Detekt report to resolve these issues. 🛠️"
      echo "*********************************************************************************"
      exit ${DETEKT_EXIT_CODE}
  else
      rm /tmp/detekt-result
      echo "🎉 Fantastic work! Your Kotlin code has sailed through Detekt's analysis with ease! Onward to greatness! 🚀🌟"
  fi
}

# Function to print success message
print_success_message() {
  GIT_USERNAME=$(git config user.name)
  echo "\n *******************************************************************************"
  echo "🚀🎉 Huzzah, $GIT_USERNAME! Your code has triumphed through the Style Checker Dragon unscathed! 🐉"
  echo "Your code shines brighter than a supernova and sparkles like a constellation of stars! ✨🌌"
  echo "*******************************************************************************"
  echo "\n🚀🎉 Hold tight, $GIT_USERNAME! Your code is ready to commit and conquer new heights! 🌟✨ Keep up the amazing work! 💪\n"
}

# Main script execution
check_current_branch
run_detekt_checks
print_success_message

exit 0