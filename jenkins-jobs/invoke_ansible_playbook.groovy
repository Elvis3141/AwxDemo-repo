// Define the job
job('Run-Ansible-Playbook') {
    description('This job fetches an Ansible playbook from GitHub and executes it.')

    // Configure the job to use Git SCM to fetch the playbook from GitHub
    scm {
        git {
            remote {
                url('https://github.com/Elvis3141/AwxDemo-repo.git/')
                // credentials('your-git-credentials-id')
            }
            branches('main') // or the branch you want to use
        }
    }

    // Configure the build step to run the Ansible playbook
    steps {
        ansiblePlaybook {
            playbookPath('playbooks/test_playbook.yml') // relative to the root of your repo
            inventoryPath('inventory/inventory.ini') // relative to the root of your repo
            // If you have extra variables, credentials, or other settings, configure them here
            // extras('--extra-vars "var1=value1 var2=value2"')
        }
    }
}
